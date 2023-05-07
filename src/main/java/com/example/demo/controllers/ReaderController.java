package com.example.demo.controllers;

import com.example.demo.models.Reader;
import com.example.demo.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Контроллер для управления читателями.
 */
@Controller
public class ReaderController {

    @Autowired
    private ReaderService service;

    /**
     * Отображает страницу со списком читателей.
     *
     * @param model                  Модель
     * @param keyword                Ключевое слово для поиска читателей
     * @param sortById               Сортировать по ID
     * @param sortByFullName         Сортировать по полному имени
     * @param sortByBirthDate        Сортировать по дате рождения
     * @param sortByAddress          Сортировать по адресу
     * @param sortByPhoneNumber      Сортировать по номеру телефона
     * @param sortByRegistrationDate Сортировать по дате регистрации
     * @return Представление со списком читателей
     */
    @RequestMapping("/readers/")
    public String viewHomePage(Model model, @Param("keyword") String keyword,
                               @RequestParam(value = "sortById", required = false, defaultValue = "false") boolean sortById,
                               @RequestParam(value = "sortByFullName", required = false, defaultValue = "false") boolean sortByFullName,
                               @RequestParam(value = "sortByBirthDate", required = false, defaultValue = "false") boolean sortByBirthDate,
                               @RequestParam(value = "sortByAddress", required = false, defaultValue = "false") boolean sortByAddress,
                               @RequestParam(value = "sortByPhoneNumber", required = false, defaultValue = "false") boolean sortByPhoneNumber,
                               @RequestParam(value = "sortByRegistrationDate", required = false, defaultValue = "false") boolean sortByRegistrationDate
    ) {
        List<Reader> listReaders = service.listAll(keyword, sortById, sortByFullName, sortByBirthDate, sortByAddress, sortByPhoneNumber, sortByRegistrationDate);
        model.addAttribute("listReaders", listReaders);
        model.addAttribute("keyword", keyword);
        return "reader/readers";
    }

    /**
     * Отображает страницу с информацией о конкретном читателе.
     *
     * @param model Модель
     * @param id    Идентификатор читателя
     * @return Представление с информацией о читателе
     */
    @RequestMapping("/reader/{id}")
    public String someFunction(Model model, @PathVariable(name = "id") Long id) throws NoSuchElementException {
        try {
            Reader reader = service.get(id);
            model.addAttribute(reader);
            return "reader/reader";
        } catch (NoSuchElementException e) {
            return "exceptions/notFoundReader";
        }
    }

    /**
     * Отображает страницу создания нового читателя.
     *
     * @param model Модель
     * @return Представление для создания нового читателя
     */
    @RequestMapping("/readers/new")
    public String showNewReaderForm(Model model) {
        Reader reader = new Reader();
        model.addAttribute("reader", reader);
        return "reader/new_reader";
    }

    /**
     * Сохраняет нового читателя.
     *
     * @param reader Читатель для сохранения
     * @return Перенаправление на страницу со списком читателей
     */
    @RequestMapping(value = "/readers/save", method = RequestMethod.POST)
    public String saveReader(@ModelAttribute("reader") Reader reader) {
        service.save(reader);
        return "redirect:/readers/";
    }

    /**
     * Отображает страницу редактирования читателя.
     *
     * @param id Идентификатор читателя для редактирования
     * @return Модель и представление для редактирования читателя
     */
    @RequestMapping("/readers/edit/{id}")
    public ModelAndView showEditReaderForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("reader/edit_reader");
        Reader reader = service.get(id);
        mav.addObject("reader", reader);
        return mav;
    }

    /**
     * Удаляет читателя.
     *
     * @param id Идентификатор читателя для удаления
     * @return Перенаправление на страницу со списком читателей
     */
    @RequestMapping("/readers/delete/{id}")
    public String deleteReader(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/readers/";
    }
}
