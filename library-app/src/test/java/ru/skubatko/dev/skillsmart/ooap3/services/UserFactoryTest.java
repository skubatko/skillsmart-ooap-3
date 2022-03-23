package ru.skubatko.dev.skillsmart.ooap3.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ru.skubatko.dev.skillsmart.ooap3.services.UserFactory.BUILD_ERR;
import static ru.skubatko.dev.skillsmart.ooap3.services.UserFactory.BUILD_OK;
import static ru.skubatko.dev.skillsmart.ooap3.services.UserFactory.GET_OK;

import ru.skubatko.dev.skillsmart.ooap3.domain.User;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Фабрика пользователей")
class UserFactoryTest {

    private final UserFactory userFactory = UserFactory.INSTANCE;

    @DisplayName("должна создавать ожидаемого пользователя")
    @SneakyThrows
    @Test
    void shouldBuildExpectedUser() {
        // given
        String type = "manager";

        // when
        userFactory.build(type);

        // then
        assertThat(userFactory.getBuildStatus()).isEqualTo(BUILD_OK);

        User user = userFactory.get();
        assertThat(userFactory.getGetStatus()).isEqualTo(GET_OK);
        assertThat(user.getRole()).isEqualTo(type);
    }

    @DisplayName("должна возвращать ожидаемый статус при отсутствии переданного типа пользователя")
    @SneakyThrows
    @Test
    void shouldReturnExpectedStatusWhenGivenUserTypeNotPresented() {
        // given
        String type = "accountant";

        // when
        userFactory.build(type);

        // then
        assertThat(userFactory.getBuildStatus()).isEqualTo(BUILD_ERR);

        userFactory.get();
        assertThat(userFactory.getGetStatus()).isNotEqualTo(GET_OK);
    }
}
