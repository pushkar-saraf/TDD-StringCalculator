package com.incubyte;

import lombok.*;

/**
 * ParsedInput class to store delimiters and numbers
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class ParsedInput {
    private String delimiter;
    private String numbers;
}
