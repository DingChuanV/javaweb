package com.uin.servlet;

import com.uin.entity.User;
import com.uin.entity.UserCriteria;
import com.uin.listener.UserCountListener;
import com.uin.service.UserService;
import com.uin.service.impl.UserServiceImpl;
import com.uin.util.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService  userService= new UserServiceImpl();
    Logger log = Logger.getLogger("UserServlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //登录
        login(req, resp);
        //注销
        logout(req, resp);
        //查询所有用户
        query(req, resp);
        //删除用户
        deleteById(req, resp);
        //更改用户
        modified(req, resp);
        //添加用户
        add(req,resp);

    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getParm(req, resp);
        if (user != null) {
            boolean isAdded = userService.addUser(user);
            if (isAdded) {
                log.info("用户添加成功！"+user);

                resp.sendRedirect("/user/query");
            }else {
                log.info("用户添加失败！"+user);

                req.getRequestDispatcher("/pages/admin/userDetail.jsp").forward(req, resp);
            }
        }else {

            req.setAttribute("msg", "数据接收出错");
            req.getRequestDispatcher("/pages/admin/userCreate.jsp").forward(req, resp);
        }
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserCriteria criteria = new UserCriteria();

        int currentPageNo = 1;
        int pageSize = 3;

        String username = req.getParameter("username");
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String usertype_str = req.getParameter("usertype");
        String currentPageNo_str = req.getParameter("currentPageNo");

        if (StringUtils.isNotEmpty(currentPageNo_str)) {
            currentPageNo_str = currentPageNo_str.trim();
            currentPageNo = StringUtils.isNumeric(currentPageNo_str) ? Integer.parseInt(currentPageNo_str) : currentPageNo;
        }
        if (StringUtils.isNotEmpty(usertype_str)) {
            int usertype = Integer.parseInt(usertype_str);
            criteria.setUsertype(usertype);
        }else {
            criteria.setUsertype(-1);
        }
        if (StringUtils.isNotEmpty(id)) {
            criteria.setId(Integer.parseInt(id));
        }else {
            criteria.setId(-1);
        }


        criteria.setUsername(username);
        criteria.setEmail(email);


        criteria.setCurrentPage(currentPageNo);
        criteria.setPageSize(pageSize);

        PageHelper<User> pageInfo = userService.queryUsers(criteria);

        if (pageInfo.getData().size() != 0) {
            log.info("用户查询成功！"+pageInfo);
            req.setAttribute("pageInfo", pageInfo);
            req.getRequestDispatcher("/pages/admin/userList.jsp").forward(req, resp);
        }else {
            log.info("用户查询失败！");

        }
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (StringUtils.isNotEmpty(id)&&StringUtils.isNumeric(id)){
            boolean isDeleted = userService.deleteUserById(Integer.parseInt(id));
            if (isDeleted) {
                log.info("用户删除成功");

                resp.sendRedirect("/user/query");
            }else {
                log.info("用户删除失败");

                req.setAttribute("msg", "用户删除失败");
                req.getRequestDispatcher("/user/query").forward(req, resp);
            }
        }else {
            req.setAttribute("msg", "您的操作异常");
            req.getRequestDispatcher("/user/query").forward(req, resp);
        }

    }

    public void modified(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //将需要修改的信息显示出来
        String mid = req.getParameter("mid");

        if (StringUtils.isNotEmpty(mid) && StringUtils.isNumeric(mid)) {
            User user = userService.queryUserById(Integer.parseInt(mid));

            req.removeAttribute("id");
            req.setAttribute("user", user);
            req.setAttribute("action","/user/modified");
            req.getRequestDispatcher(req.getContextPath() + "/pages/admin/userDetail.jsp").forward(req, resp);
        }else if (StringUtils.isEmpty(mid)){

            //获取user的所有属性
            User user = getParm(req, resp);
            //获取需要修改的信息，并在数据库中更新
            boolean flag = userService.updateUser(user);
            if (flag) {
                log.info("修改用户成功");

                resp.sendRedirect("/user/query");
            }else {
                log.info("修改用户失败");

                req.setAttribute("mid",user.getId());
                req.setAttribute("action","/user/modified");//值不为空就可以
                req.getRequestDispatcher(req.getContextPath()+"/pages/admin/userDetail.jsp").forward(req,resp);
            }
        }
    }


    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userCountListener");

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)) {
            User user = userService.login(username, password);
            if (user != null&&user.getId()!=0) {
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                //将监听器绑定到session中
                session.setAttribute("userCountListener",new UserCountListener());

                resp.sendRedirect(req.getContextPath()+"/pages/admin/admin.jsp");
            }else {
                //保存用户的输入信息
                User input_msg = new User();
                input_msg.setUsername(username);
                input_msg.setPassword(password);
                req.setAttribute("input_msg",input_msg);

                req.setAttribute("msg","登录失败，请检查你的用户名或密码是否正确。");
                req.getRequestDispatcher(req.getContextPath() + "/index.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("msg","请输入用户名和密码");
            req.getRequestDispatcher(req.getContextPath() + "/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 得到前端页面传来的数据
     * @param req
     * @param resp
     * @return 将前端数据封装为一个对象
     */
    public User getParm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String con_password = req.getParameter("con_password");
        String email = req.getParameter("email");
        String usertype = req.getParameter("usertype");

        //如果确认密码和密码相同，返回一个User类
        if (password.equals(con_password)) {
            if (StringUtils.isNotEmpty(id)) {
                return new User(Integer.parseInt(id), username, password, email, Integer.parseInt(usertype));

            }else {
                return new User(username, password, email, Integer.parseInt(usertype));
            }
        }else {
            return null;
        }


    }
}
