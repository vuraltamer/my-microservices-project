package com.project.controller;

import com.project.dto.base.BaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public abstract class BaseController<T, S extends BaseDto>  extends BaseExceptionHandler {

	@GetMapping("/")
	protected RedirectView home() {
		return new RedirectView("/swagger-ui.html");
	}

	protected abstract ResponseEntity<S> findById(String id);

	protected abstract ResponseEntity save(S dto);

	protected abstract ResponseEntity delete(String id);

	protected abstract ResponseEntity update(S dto);

	protected abstract ResponseEntity<List<S>> list();

}
