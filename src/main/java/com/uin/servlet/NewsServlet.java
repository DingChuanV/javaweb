package com.uin.servlet;


import com.uin.entity.NewsCriteria;
import com.uin.entity.News;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import com.uin.service.NewsService;
import com.uin.service.impl.NewsServiceImpl;
import com.uin.util.PageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 */
@WebServlet("/news/*")
public class NewsServlet extends BaseServlet{
    private NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //添加新闻
        add(req, resp);
        //分页查询新闻
        query(req, resp);
        //查询某个新闻
        queryById(req, resp);
        //修改新闻
        modified(req, resp);
        //删除新闻
        delById(req, resp);


    }

    public void delById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ids = req.getParameter("id");
        if (StringUtils.isNotEmpty(ids) && StringUtils.isNumeric(ids)) {

            boolean isDeleted = newsService.delete(Integer.parseInt(ids));

            if (isDeleted) {
                req.setAttribute("msg","id为"+ids+"的新闻删除成功！");
                req.getRequestDispatcher("/news/query").forward(req, resp);
            }else {
                req.setAttribute("msg","id为"+ids+"的新闻删除失败！");
                req.getRequestDispatcher("/news/query").forward(req, resp);
            }
        }
    }

    public void modified(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //将需要修改的信息显示出来
        String mid = req.getParameter("mid");
        if (StringUtils.isNotEmpty(mid) && StringUtils.isNumeric(mid)) {
            News news = newsService.getNewsById(Integer.parseInt(mid));
            req.setAttribute("news", news);
            req.setAttribute("action","/news/modified");
            req.getRequestDispatcher(req.getContextPath() + "/pages/admin/newsDetailCreateSimple.jsp").forward(req, resp);
        }else if (StringUtils.isEmpty(mid)){
            News news = new News();
            //获取news的所有属性
            getParm(req, resp, news);
            //获取需要修改的信息，并在数据库中更新
            boolean flag = newsService.update(news);
            if (flag) {
                System.out.println("修改新闻成功");
                resp.sendRedirect("/news/query");
            }else {
                System.out.println("修改新闻失败");
                req.setAttribute("mid",news.getId());
                req.setAttribute("action","/news/modified");
                req.getRequestDispatcher(req.getContextPath()+"/pages/admin/newsDetailCreateSimple.jsp").forward(req,resp);
            }
        }

    }

    public void queryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        News news = newsService.getNewsById(id);
        req.setAttribute("news", news);
        req.getRequestDispatcher(req.getContextPath() + "/pages/admin/newsDetailView.jsp").forward(req, resp);
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        NewsCriteria criteria = new NewsCriteria();

        int categoryId = 0;
        String title = "";
        int currentPageNo = 1;
        int pageSize = 3;


        String categoryId_str = req.getParameter("categoryId");
        String title_str = req.getParameter("title");
        String currentPageNo_str = req.getParameter("currentPageNo");

        if (StringUtils.isNotEmpty(categoryId_str)) {
            categoryId_str = categoryId_str.trim();
            categoryId = StringUtils.isNumeric(categoryId_str) ? Integer.parseInt(categoryId_str) : 0;
        }

        if (StringUtils.isNotEmpty(title_str)) {
            title = title_str.trim();
        }
        //将查询条件显示在input输入框表单中
        req.setAttribute("title", title);

        if (StringUtils.isNotEmpty(currentPageNo_str)) {
            currentPageNo_str = currentPageNo_str.trim();
            currentPageNo = StringUtils.isNumeric(currentPageNo_str) ? Integer.parseInt(currentPageNo_str) : currentPageNo;
        }

        //int pageCount = newsService.countNews(new Criteria(categoryId, title));

        if (currentPageNo < 1) {
            currentPageNo = 1;
        }
        criteria.setCategoryId(categoryId);
        criteria.setTitle(title);
        criteria.setCurrentPage(currentPageNo);
        criteria.setPageSize(pageSize);

        PageHelper<News> pageInfo = newsService.getListWithPagingInfo(criteria);

        req.setAttribute("pageInfo", pageInfo);

        req.getRequestDispatcher("/pages/admin/newsDetailList.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //是否上传成功
        boolean upload = false;

        News news = new News();

        getParm(req, resp, news);
        //数据库插入信息
        boolean isAdded = newsService.add(news);

        //如果添加成功
        if (isAdded) {
            System.out.println("添加新闻成功");
            resp.sendRedirect("/news/query");
        } else {
            System.out.println("添加新闻失败");
            resp.sendRedirect("/pages/admin/newsDetailCreateSimple.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 解析请求中的参数，并将对应的值赋值给传来的news参数
     * @param req
     * @param resp
     * @param news 需要赋值的参数
     */
    public void getParm(HttpServletRequest req,HttpServletResponse resp,News news) {
        //解析请求类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);

        //指定上传位置
        String uploadFilePath = req.getSession().getServletContext().getRealPath("upload/");
        File saveDir = new File(uploadFilePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }

        //如果是多媒体类型
        if (isMultipart) {
            //创建文件工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //创建文件上传类
            ServletFileUpload fileUpload = new ServletFileUpload(factory);

            // 解析请求
            List<FileItem> items;
            try {
                //解析请求域
                items = fileUpload.parseRequest(req);
                //分别得到对应的数据
                for (FileItem item : items) {
                    //普通表单域
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();

                        switch (fieldName) {
                            case "id":
                                if (StringUtils.isNotEmpty(item.getString("utf-8"))) {
                                    news.setId(Integer.parseInt(item.getString("utf-8")));
                                }
                                break;
                            case "title":
                                news.setTitle(item.getString("utf-8"));
                                break;
                            case "categoryId":
                                news.setCategoryId(Integer.parseInt(item.getString("utf-8")));
                                break;
                            case "author":
                                news.setAuthor(item.getString("utf-8"));
                                break;
                            case "summary":
                                news.setSummary(item.getString("utf-8"));
                                break;
                            case "newscontent":
                                news.setContent(item.getString("utf-8"));
                                break;
                        }

                    } else {
                        String fileName = item.getName();
                        if (fileName != null && !fileName.equals("")) {

//                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//                            Date date = new Date();
//                            String dateStr = format.format(date);
//
//                            String prefix = item.getName().substring(0, item.getName().lastIndexOf('.'));
//                            String postfix = item.getName().substring(item.getName().lastIndexOf('.'));
                            //文件名(上传文件名+上传时间+后缀名)
//                            File fullFile = new File(prefix + "(" + dateStr + ")" + postfix);
                            File fullFile = new File(item.getName());
                            //保存的文件（路径+文件名）
                            File saveFile = new File(uploadFilePath, fullFile.getName());

                            item.write(saveFile);

                            System.out.println("文件名为：" + fullFile);
                            System.out.println("文件路径为：" + saveFile);

                            String uploadFileName = fullFile.getName();
                            news.setPicpath(uploadFileName);


                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
