package com.Confer.ConferWeb.Controllers;

import com.Confer.ConferWeb.Services.EpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/epis")
public class EpiController {

    @Autowired
    private EpiService epiService;


}