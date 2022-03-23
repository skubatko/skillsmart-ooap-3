package ru.skubatko.dev.skillsmart.ooap3.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.DELETE_ERR;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.DELETE_NIL;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.DELETE_OK;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.FIND_ERR;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.FIND_NIL;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.FIND_OK;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.UPDATE_ERR;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.UPDATE_NIL;
import static ru.skubatko.dev.skillsmart.ooap3.repositories.Repository.UPDATE_OK;

import ru.skubatko.dev.skillsmart.ooap3.domain.Book;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Репозиторий")
class RepositoryTest {

    private Repository<Book, Long> repository = new BookRepository();

    @DisplayName("должен находить ожидаемый элемент по заданному идентификатору")
    @SneakyThrows
    @Test
    void shouldFindExpectedElementByGivenId() {
        // given
        Long id = 1L;
        Book book = new Book(id, "testBook", "testAuthor");
        repository.save(id, book);
        assertThat(repository.getFindStatus()).isEqualTo(FIND_NIL);

        // when
        Book expected = repository.findById(id);

        // then
        assertThat(expected).isEqualTo(book);
        assertThat(repository.getFindStatus()).isEqualTo(FIND_OK);
    }

    @DisplayName("должен возвращать ожидаемый статус при поиске отсутствующего элемента")
    @SneakyThrows
    @Test
    void shouldReturnExpectedStatusWhenFindNotPersistedElement() {
        // given
        Long id = 1L;
        assertThat(repository.getFindStatus()).isEqualTo(FIND_NIL);

        // when
        repository.findById(id);

        // then
        assertThat(repository.getFindStatus()).isEqualTo(FIND_ERR);
    }

    @DisplayName("должен обновлять элемент по заданному идентификатору")
    @SneakyThrows
    @Test
    void shouldUpdateElementByGivenId() {
        // given
        Long id = 1L;
        Book book = new Book(id, "testBook", "testAuthor");
        repository.save(id, book);
        book.setName("updatedBook");
        assertThat(repository.getUpdateStatus()).isEqualTo(UPDATE_NIL);

        // when
        repository.update(id, book);

        // then
        Book expected = repository.findById(id);
        assertThat(expected).isEqualTo(book);
        assertThat(repository.getUpdateStatus()).isEqualTo(UPDATE_OK);
    }

    @DisplayName("должен возвращать ожидаемый статус при обновлении отсутствующего элемента")
    @SneakyThrows
    @Test
    void shouldReturnExpectedStatusWhenUpdateNotPersistedElement() {
        // given
        Long id = 1L;
        Book book = new Book(id, "updatedBook", "testAuthor");
        assertThat(repository.getUpdateStatus()).isEqualTo(UPDATE_NIL);

        // when
        repository.update(id, book);

        // then
        assertThat(repository.getUpdateStatus()).isEqualTo(UPDATE_ERR);
    }

    @DisplayName("должен удалять элемент по заданному идентификатору")
    @SneakyThrows
    @Test
    void shouldDeleteElementByGivenId() {
        // given
        Long id = 1L;
        Book book = new Book(id, "testBook", "testAuthor");
        repository.save(id, book);
        assertThat(repository.getDeleteStatus()).isEqualTo(DELETE_NIL);

        // when
        repository.delete(id);

        // then
        repository.findById(id);
        assertThat(repository.getFindStatus()).isEqualTo(FIND_ERR);
        assertThat(repository.getDeleteStatus()).isEqualTo(DELETE_OK);
    }

    @DisplayName("должен возвращать ожидаемый статус при удалении отсутствующего элемента")
    @SneakyThrows
    @Test
    void shouldReturnExpectedStatusWhenDeleteNotPersistedElement() {
        // given
        Long id = 1L;
        assertThat(repository.getDeleteStatus()).isEqualTo(DELETE_NIL);

        // when
        repository.delete(id);

        // then
        assertThat(repository.getDeleteStatus()).isEqualTo(DELETE_ERR);
    }
}
