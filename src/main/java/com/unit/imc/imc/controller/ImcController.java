package com.unit.imc.imc.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unit.imc.imc.model.Imc;

@RestController
@RequestMapping("/imc")
public class ImcController {

    @GetMapping
    public Imc getAll(@RequestParam double altura, @RequestParam double peso) {
        double imc = peso / (altura * 2);

        Imc imcModel = new Imc();

        imcModel.altura = String.format("%.2f", altura).replace(".", ",");
        imcModel.peso = String.format("%.2f", peso).replace(".", ",");
        imcModel.classification = ImcClassification(imc);
        imcModel.imc = String.format("%.2f", imc);
        return imcModel;
    }

    private String ImcClassification(double imc) {
        if(imc < 18.5) {
            return "Baixo peso / Underweight";
        } 
        else if(imc >= 18.5 && imc < 25) {
            return "Intervalo Normal / Normal weight";
        } 
        else if(imc >= 25 && imc < 30) {
            return "Sobrepeso / Overweight";
        } 
        else if(imc >= 30 && imc < 35) {
            return "Obesidade classe I / Obesity";
        } 
        else if(imc >= 35 && imc < 40) {
            return "Obesidade classe II / Obesity II";
        } 
        return "Obesidade classe III / Obesity III";
    }
}
