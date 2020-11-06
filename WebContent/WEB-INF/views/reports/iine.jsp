<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>いいねした従業員</h2>
        <table>
        <tbody>
          <tr>
              <th>氏名</th>
              <th>日付</th>
          </tr>
           <c:forEach var="iine" items="${iines}" >
               <tr>
                <td><c:out value="${iine.employee.name}"/></td>
                <td><c:out value="${iine.created_at }"/></td>
               </tr>
           </c:forEach>

        </tbody>
       </table>
     </c:param>
</c:import>