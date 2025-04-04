package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Child extends Person {
    private String CertificateNumber;
    private LocalDate issueDate;
    private String issueDepartment;

    public String getCertificateNumber() {
        return CertificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        CertificateNumber = certificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
