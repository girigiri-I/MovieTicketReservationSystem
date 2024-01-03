package com.mov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryForm {
    private String userName;
    private String scheduleId;
    private String bookingId;
}
