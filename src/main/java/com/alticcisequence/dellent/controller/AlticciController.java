package com.alticcisequence.dellent.controller;


import com.alticcisequence.dellent.config.SwaggerConfig;
import com.alticcisequence.dellent.service.AlticciService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/alticci")
@AllArgsConstructor
@Api(tags = {SwaggerConfig.ALTICCI})
@Validated
public class AlticciController {

    private AlticciService service;

    @ApiOperation(value = "Retorna o valor Alticci para o índice informado")
    @GetMapping("{n}")
    public ResponseEntity<Integer> getAlticciValue(@ApiParam(value = "Valor para cálculo alticci.", required = true)
                                                   @PathVariable @PositiveOrZero int n){
        return ResponseEntity.ok(service.calculate(n));
    }

}
