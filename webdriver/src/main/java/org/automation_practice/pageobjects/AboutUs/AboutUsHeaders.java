package org.automation_practice.pageobjects.AboutUs;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum AboutUsHeaders {

    ALL_ABOUT_GOOGLE("Wszystko o Google"),
    PRODUCTS("Produkty i usługi"),
    COMMITMENTS("Zobowiązania"),
    STORIES("Historie");

    private final String headerName;

    public static List<String> exceptedHeaders() {
        return Arrays.stream(values()).map(header -> header.headerName.toLowerCase()).collect(Collectors.toList());
    }
}
