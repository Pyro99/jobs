package com.example.jobapp.company.service;

import com.example.jobapp.company.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);

    boolean updateCompany(Company company, Long id);

    boolean deleteCompany(Long id);

    Company getCompanyById(Long id);




}
