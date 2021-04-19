package com.frontbackend.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.frontbackend.springboot.model.Snippet;

@SpringBootTest
public class SnippetRepositoryTest {

    @Autowired
    private SnippetRepository snippetRepository;

    @BeforeEach
    public void setUp() {
        snippetRepository.deleteAll();
    }

    @Test
    public void shouldSaveSnippet() {
        Snippet snippet = new Snippet("alert('test')", "javascript");

        Snippet saved = snippetRepository.insert(snippet);

        System.out.println(saved);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        Optional<Snippet> snippetOptional = snippetRepository.findById(saved.getId());
        assertThat(snippetOptional).isPresent();
    }

    @Test
    public void shouldUpdateSnippet() {
        Snippet snippet = new Snippet("alert('test')", "javascript");

        Snippet saved = snippetRepository.save(snippet);
        saved.setLanguage("es6");
        snippetRepository.save(saved);

        Optional<Snippet> snippetOptional = snippetRepository.findById(saved.getId());
        assertThat(snippetOptional).isPresent();

        Snippet updated = snippetOptional.get();
        assertThat(updated.getLanguage()).isEqualTo("es6");
    }

    @Test
    public void shouldRemoveByIdSnippet() {
        Snippet snippet = new Snippet("alert('test')", "javascript");

        Snippet saved = snippetRepository.save(snippet);
        snippetRepository.deleteById(saved.getId());

        Optional<Snippet> byId = snippetRepository.findById(saved.getId());
        assertThat(byId).isNotPresent();
    }

    @Test
    public void shouldFoundById() {
        Snippet snippet = new Snippet("alert('test')", "javascript");

        Snippet saved = snippetRepository.save(snippet);

        Optional<Snippet> byId = snippetRepository.findById(saved.getId());
        assertThat(byId).isPresent();
    }

    @Test
    public void shouldFindAll() {
        Snippet snippet1 = new Snippet("alert('test')", "javascript");
        Snippet snippet2 = new Snippet("() => alert('test')", "es6");

        snippetRepository.save(snippet1);
        snippetRepository.save(snippet2);

        List<Snippet> all = snippetRepository.findAll();

        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    public void shouldFindAllPageable() {
        Snippet snippet1 = new Snippet("alert('test')", "javascript");
        Snippet snippet2 = new Snippet("() => alert('test')", "es6");

        snippetRepository.save(snippet1);
        snippetRepository.save(snippet2);

        Pageable pageableRequest = PageRequest.of(0, 1); // first page, page size = 1
        Page<Snippet> paged = snippetRepository.findAll(pageableRequest);

        assertThat(paged.getTotalElements()).isEqualTo(2);
        assertThat(paged.getTotalPages()).isEqualTo(2);
        assertThat(paged.getContent()
                        .size()).isEqualTo(1);
    }

    @Test
    public void shouldExists() {
        Snippet snippet = new Snippet("alert('test')", "javascript");

        Snippet saved = snippetRepository.save(snippet);

        assertThat(snippetRepository.existsById(saved.getId())).isTrue();
    }

    @Test
    public void shouldSort() {
        Snippet snippet1 = new Snippet("alert('test')", "javascript");
        Snippet snippet2 = new Snippet("() => alert('test')", "es6");

        snippetRepository.save(snippet1);
        snippetRepository.save(snippet2);

        Sort sortBy = Sort.by(Sort.Direction.ASC, "language");
        List<Snippet> sorted = snippetRepository.findAll(sortBy);

        assertThat(sorted.get(0)
                         .getLanguage()).isEqualTo("es6");
    }
}
