package com.example.PortfolioLukaszKolacz;

import com.example.PortfolioLukaszKolacz.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 10.06.2017.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
    List<Project> findAll();
}
