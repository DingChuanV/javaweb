package com.uin.servlet; /**
 *
 */

import com.uin.entity.Category;
import com.uin.service.CategoryService;
import com.uin.service.impl.CategoryServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService cs = new CategoryServiceImpl();
    Logger logger = Logger.getLogger("CategoryServlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        add(req, resp);
        deleteById(req, resp);
        modified(req, resp);
        query(req, resp);
        queryById(req,resp);
    }

    public void queryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (StringUtils.isNotEmpty(id)) {
            Category category = cs.getCategoryById(Integer.parseInt(id));

            if (category != null && category.getId() != 0) {
                logger.info("通过id查询分类成功");
                req.setAttribute("category", category);
                req.getRequestDispatcher("/pages/admin/categoryDetail.jsp").forward(req, resp);
            }else {
                logger.info("通过id查询分类失败");
                req.setAttribute("category", "通过id查询分类失败");
                req.getRequestDispatcher("/category/query").forward(req, resp);
            }


        }else {
            logger.info("通过id查询分类失败（id参数异常）");
            req.setAttribute("msg", "通过id查询分类失败（id参数异常）");
            req.getRequestDispatcher("/category/query").forward(req, resp);
        }
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (StringUtils.isNotEmpty(id)) {
            boolean flag = cs.delCategoryById(Integer.parseInt(id));
            if (flag) {
                logger.info("分类删除成功");
                req.setAttribute("msg","分类删除成功");
                req.getRequestDispatcher("/category/query").forward(req,resp);
            }else {
                logger.info("分类删除失败");
                req.setAttribute("msg","分类删除失败");
                req.getRequestDispatcher("/category/query").forward(req,resp);
            }
        } else {
            logger.info("分类删除失败！id参数异常");
            req.setAttribute("msg","分类删除失败！id参数异常");
            req.getRequestDispatcher("/category/query").forward(req,resp);

        }

    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> categories = cs.getCategory();

        if (!categories.isEmpty()) {
            logger.info("查询成功！");
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/pages/admin/categoryList.jsp").forward(req,resp);
        }else {
            logger.info("查询失败");
        }
    }

    public void modified(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");

        //mid为空则说明是需要执行修改操作（）
        // 否则则是执行进入修改页面操作(需要通过mid读取该条数据)
        if (StringUtils.isNotEmpty(mid)) {
            Category category = cs.getCategoryById(Integer.parseInt(mid));

            req.setAttribute("category", category);
            req.setAttribute("action","随便什么都行(只要不为空)");
            req.getRequestDispatcher("/pages/admin/categoryDetail.jsp").forward(req,resp);
        }else if (StringUtils.isEmpty(mid)){
            String id = req.getParameter("id");
            String name = req.getParameter("name");

            Category category = new Category();
            category.setName(name);
            category.setId(Integer.parseInt(id));

            boolean flag = cs.updateCategory(category);

            if (flag) {
                logger.info("分类修改成功");

                req.setAttribute("msg", "分类修改成功");
                req.getRequestDispatcher("/category/query").forward(req, resp);
            } else {

                logger.info("分类修改失败");

                req.setAttribute("msg", "分类修改失败");
                req.getRequestDispatcher("/pages/admin/categoryDetail.jsp").forward(req, resp);
            }
        }


    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        Category category = new Category();
        category.setName(name);
        boolean flag = cs.addCategory(category);

        if (flag) {

            logger.info("添加新闻成功");

            req.setAttribute("msg", "添加新闻成功");
            req.getRequestDispatcher("/category/query").forward(req, resp);
        }else {
            logger.info("添加新闻失败");

            req.setAttribute("msg", "添加新闻失败");
            req.getRequestDispatcher("/pages/admin/categoryDetail.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
