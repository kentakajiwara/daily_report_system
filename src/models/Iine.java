package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "iine")
@NamedQueries({
    @NamedQuery(
            name = "getIineList",
            query = "SELECT i FROM Iine AS i  ORDER BY i.id DESC"
            ),
    @NamedQuery(
            name = "getReportlist",
            query = "SELECT i FROM Iine AS i WHERE i.report = :report ORDER BY i.id DESC"
            ),
    })

@Entity
public class Iine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    (name = "employee_id",nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn
    (name = "report_id" ,nullable = false)
    private Report report;


    @Column(name = "created_at",nullable = false)
    private Timestamp created_at;

    @Column(name = "update_at", nullable = false)
    private Timestamp update_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }



    }


