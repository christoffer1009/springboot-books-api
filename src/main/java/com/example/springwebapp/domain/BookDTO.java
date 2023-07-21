package com.example.springwebapp.domain;

import java.util.Set;

public record BookDTO(Long id, String title, String isbn, Set<Long> authorsIds, Long publisherId) {
}
