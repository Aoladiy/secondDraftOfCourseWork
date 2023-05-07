package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Example;
import com.example.demo.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления примерами.
 */
@Controller
public class ExampleController {

    @Autowired
    private ExampleService service;

    /**
     * Отображает страницу со списком примеров.
     *
     * @param model                     Модель
     * @param keyword                   Ключевое слово для поиска примеров
     * @param ByReaderId                Идентификатор читателя для фильтрации
     * @param ByBookId                  Идентификатор книги для фильтрации
     * @param sortById                  Сортировать по ID
     * @param sortByDistinctiveFeatures Сортировать по особенностям
     * @param sortByDateIssue           Сортировать по дате выдачи
     * @param sortByDateReturn          Сортировать по дате возврата
     * @return Представление со списком примеров
     */
    @RequestMapping("/examples/")
    public String viewHomePage(Model model,
                               @Param("keyword") String keyword,
                               @Param("ByReaderId") String ByReaderId,
                               @Param("ByBookId") String ByBookId,
                               @RequestParam(value = "sortById", required = false, defaultValue = "false") boolean sortById,
                               @RequestParam(value = "sortByDistinctiveFeatures", required = false, defaultValue = "false") boolean sortByDistinctiveFeatures,
                               @RequestParam(value = "sortByDateIssue", required = false, defaultValue = "false") boolean sortByDateIssue,
                               @RequestParam(value = "sortByDateReturn", required = false, defaultValue = "false") boolean sortByDateReturn
    ) {
        List<Example> listExamples = service.listAll(keyword, ByReaderId, ByBookId, sortById, sortByDistinctiveFeatures, sortByDateIssue, sortByDateReturn);
        model.addAttribute("listExamples", listExamples);
        model.addAttribute("keyword", keyword);
        model.addAttribute("ByReaderId", ByReaderId);
        model.addAttribute("ByBookId", ByBookId);
        return "example/examples";
    }

    /**
     * Отображает страницу с информацией о конкретном примере.
     *
     * @param model Модель
     * @param id    Идентификатор примера
     * @return Представление с информацией о примере
     */
    @RequestMapping("/example/{id}")
    public String someFunction(Model model, @PathVariable(name = "id") Long id) {
        Example example = service.get(id);
        model.addAttribute(example);
        return "example/example";
    }

    /**
     * Отображает страницу создания нового примера.
     *
     * @param model Модель
     * @return Представление для создания нового примера
     */
    @RequestMapping("/examples/new")
    public String showNewExampleForm(Model model) {
        Example example = new Example();
        model.addAttribute("example", example);
        return "example/new_example";
    }

    /**
     * Сохраняет новый пример.
     *
     * @param example Пример для сохранения
     * @return Перенаправление на страницу со списком примеров
     */
    @RequestMapping(value = "/examples/save", method = RequestMethod.POST)
    public String saveExample(@ModelAttribute("example") Example example) {
        service.save(example);
        return "redirect:/examples/";
    }

    /**
     * Отображает страницу редактирования примера.
     *
     * @param id Идентификатор примера для редактирования
     * @return Модель и представление для редактирования примера
     */
    @RequestMapping("/examples/edit/{id}")
    public ModelAndView showEditExampleForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("example/edit_example");
        Example example = service.get(id);
        mav.addObject("example", example);
        return mav;
    }

    /**
     * Удаляет пример.
     *
     * @param id Идентификатор примера для удаления
     * @return Перенаправление на страницу со списком примеров
     */
    @RequestMapping("/examples/delete/{id}")
    public String deleteExample(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/examples/";
    }
}