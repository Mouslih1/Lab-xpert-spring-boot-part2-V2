package com.example.labxpert.Controller;

import com.example.labxpert.Dtos.AnalyseDto;
import com.example.labxpert.Exception.MessageErrorException.MessageError;
import com.example.labxpert.Model.Enum.TypeAnalyse;
import com.example.labxpert.Service.IAnalyseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/analyses")
public class AnalyseController {

    private final IAnalyseService iAnalyseService;

    @GetMapping
    public ResponseEntity<List<AnalyseDto>> getAll()
    {
        return ResponseEntity.ok(iAnalyseService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<AnalyseDto> save(@RequestBody @Valid AnalyseDto analyseDto)
    {
        AnalyseDto analyseSaved = iAnalyseService.add(analyseDto);
        return new ResponseEntity<>(analyseSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AnalyseDto> update(@PathVariable Long id, @RequestBody @Valid AnalyseDto analyseDto)
    {
        AnalyseDto analyseUpdated = iAnalyseService.update(id, analyseDto);
        return new ResponseEntity<>(analyseUpdated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalyseDto> getById(@PathVariable Long id)
    {
        try{
            AnalyseDto analyse = iAnalyseService.getById(id);
            return new ResponseEntity<>(analyse, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<MessageError> delete(@PathVariable Long id)
    {
        MessageError messageError = new MessageError("Analyse deleted successfully.");
        iAnalyseService.delete(id);
        return new ResponseEntity<>(messageError, HttpStatus.OK);
    }

    @GetMapping("/type-analyse")
    public ResponseEntity<AnalyseDto> getByTypeAnalyse(TypeAnalyse typeAnalyse)
    {
        try{
            AnalyseDto analyse = iAnalyseService.getByTypeAnalyse(typeAnalyse);
            return new ResponseEntity<>(analyse, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
