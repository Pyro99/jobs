package com.example.jobapp.company.controller;

import com.example.jobapp.company.entity.Company;
import com.example.jobapp.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompanies(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanies(@RequestBody Company company, @PathVariable Long id) {
        companyService.updateCompany(company,id);
        return new ResponseEntity<>("Companies Updated Successfully", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompany(id);
        if(isDeleted) {
            return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
        }
            return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
    }
}
