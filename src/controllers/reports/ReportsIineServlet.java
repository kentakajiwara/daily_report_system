package controllers.reports;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Iine;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsIineServlet
 */
@WebServlet("/reports/iine")
public class ReportsIineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsIineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        Report r = em.find(Report.class , Integer.parseInt(request.getParameter("id")));

            int count = r.getIine_count();
            count++;
            r.setIine_count(count);


            Iine i = new Iine();
           /* {Date report_date = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("report_date");
            if(rd_str != null && !rd_str.equals("")) {
                report_date = Date.valueOf(request.getParameter("report_date"));
            }
            */
            i.setId((Integer)request.getSession().getAttribute("employee_id"));
            i.setEmployee((Employee)request.getSession().getAttribute("login_employee"));
            i.setReport(r);




            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            i.setCreated_at(currentTime);
            i.setUpdate_at(currentTime);


        em.getTransaction().begin();
        em.persist(r);
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        request.getSession().setAttribute("flush", "いいねを追加しました。");


        response.sendRedirect(request.getContextPath() + "/reports/index");


    }

}
