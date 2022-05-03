package com.inc.qualle.service.impl;

import com.inc.qualle.config.ReportConfig;
import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class WordReportService implements ReportService {

    private final ReportConfig reportConfig;

    @Override
    public void generate(Collection<ProductDto> dto) {
        try {
            generateProductReport(dto);
        } catch (IOException e) {
            log.warn("Unable to generate report", e);
        }
    }

    private void generateProductReport(Collection<ProductDto> dto) throws IOException {
        String targetPath = reportConfig.getOutputPath() + getFileName();

        write(targetPath, prepareBook(getData(dto)));
    }

    private List<List<String>> getData(Collection<ProductDto> list) {
        List<List<String>> data = new ArrayList<>();

        for (ProductDto dto : list) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(dto.getId()));
            row.add(dto.getTitle());
            row.add(dto.getDescription());
            row.add(String.valueOf(dto.getPrice()));
            row.add(dto.getType().toString());
            row.add(dto.getCategory().getValue());
            row.add(dto.getDeveloper().getTitle());
            row.add(dto.getGenre().getValue());
            row.add(dto.getImage().getLink());
            data.add(row);
        }
        return data;
    }

    private XSSFWorkbook prepareBook(List<List<String>> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Products");

        int rowId = 0;
        for (List<String> dataRow : data) {
            Row row = sheet.createRow(rowId++);
            int colId = 0;
            for (String field : dataRow) {
                Cell cell = row.createCell(colId++);
                cell.setCellValue(field);
            }
        }
        return workbook;
    }

    private void write(String filename, XSSFWorkbook workbook) {

        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            workbook.write(outputStream);
            workbook.close();

        } catch (IOException e) {
            log.warn("Unable to write report", e);
        }
    }

    private String getFileName() {
        return "products-report-" + getCurrentDate() + ".xlsx";
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}