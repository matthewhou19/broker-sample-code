package com.example.demo.dataSimulation;

import com.example.demo.CustomerRespondEntity;
import com.example.demo.CustomerResponseRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CustomerResponseRepository repository;

    @Override
    public void run(String... args) throws Exception {
        loadExcelData();
    }

    private void loadExcelData() {
        String excelFilePath = "Example File.xlsx"; // Path relative to src/main/resources
        try (InputStream inputStream = new ClassPathResource(excelFilePath).getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)){

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { // Skip header row
                    continue;
                }

                CustomerRespondEntity entity = new CustomerRespondEntity();
                entity.setId(Long.parseLong(getCellValue(row, 0)));
                entity.setDate(getCellValue(row, 1));
                entity.setName(getCellValue(row, 2));
                entity.setPhoneNumber(getCellValue(row, 3));
                entity.setEmail(getCellValue(row, 4));
                entity.setVehicle(getCellValue(row, 5));
                entity.setYear(Integer.parseInt(getCellValue(row, 6)));
                entity.setMake(getCellValue(row, 7));
                entity.setModel(getCellValue(row, 8));
                entity.setVehicleType(getCellValue(row, 9));
                entity.setVehicleCondition(getCellValue(row, 10));
                entity.setOriginState(getCellValue(row, 11));
                entity.setOriginZipCode(getCellValue(row, 12));
                entity.setDestinationState(getCellValue(row, 13));
                entity.setDestinationZipCode(getCellValue(row, 14));
                entity.setEstimateShippingDate(getCellValue(row, 15));
                entity.setArchivedStatus(getCellValue(row, 16));
                entity.setAssignedTo(getCellValue(row, 17));

                repository.save(entity);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCellValue(Row row, int cellNum) {
        Cell cell = row.getCell(cellNum);
        return cell == null ? null : cell.toString();
    }
}
