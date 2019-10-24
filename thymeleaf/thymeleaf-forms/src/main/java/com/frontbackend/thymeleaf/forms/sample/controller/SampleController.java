package com.frontbackend.thymeleaf.forms.sample.controller;

import com.frontbackend.thymeleaf.forms.sample.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {

    @ModelAttribute("allSampleColors")
    public SampleColor[] getAllSampleColors() {
        return SampleColor.values();
    }

    @PostMapping("/sampleInputs")
    public String saveInputs(SampleInputs sampleInputs, BindingResult bindingResult) {
        log.info("command object = {}", sampleInputs);
        return "sampleInputs";
    }


    @GetMapping("/sampleInputs")
    public String sampleInputs(Model model) {
        model.addAttribute("sampleInputs", new SampleInputs());
        return "sampleInputs";
    }

    @PostMapping("/sampleCheckboxes")
    public String saveCheckboxes(SampleCheckboxes sampleCheckboxes, BindingResult bindingResult) {
        log.info("command object = {}", sampleCheckboxes);
        return "sampleCheckboxes";
    }

    @GetMapping("/sampleCheckboxes")
    public String sampleCheckboxes(Model model) {
        model.addAttribute("sampleCheckboxes", new SampleCheckboxes());
        return "sampleCheckboxes";
    }


    @PostMapping("/sampleRadioButtons")
    public String saveRadioButtons(SampleRadioButtons sampleCheckboxes,
            BindingResult bindingResult) {
        log.info("command object = {}", sampleCheckboxes);
        return "sampleRadioButtons";
    }

    @GetMapping("/sampleRadioButtons")
    public String sampleRadioButtons(Model model) {
        model.addAttribute("sampleRadioButtons", new SampleRadioButtons());
        return "sampleRadioButtons";
    }



    @PostMapping("/sampleDropdowns")
    public String saveSampleDropdowns(SampleDropdowns sampleDropdowns,
                                   BindingResult bindingResult) {
        log.info("command object = {}", sampleDropdowns);
        return "sampleDropdowns";
    }

    @GetMapping("/sampleDropdowns")
    public String sampleDropdowns(Model model) {
        model.addAttribute("sampleDropdowns", new SampleDropdowns());
        return "sampleDropdowns";
    }
}
