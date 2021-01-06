package com.frontbackend.libraries.apachepoi.parser;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXParser<T> {

    private static final int HEADER_ROW_INDEX = 0;
    private static final int SHEET_INDEX = 0;

    public List<T> parse(InputStream inputStream, Class<T> cls) throws Exception {
        List<T> out = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(SHEET_INDEX);

        List<XLSXHeader> xlsxHeaders = modelObjectToXLSXHeader(cls, sheet);
        for (Row row : sheet) {
            if (row.getRowNum() > HEADER_ROW_INDEX) {
                out.add(createRowObject(xlsxHeaders, row, cls));
            }
        }

        return out;
    }

    private T createRowObject(List<XLSXHeader> xlsxHeaders, Row row, Class<T> cls) throws Exception {
        T obj = cls.newInstance();
        Method[] declaredMethods = obj.getClass()
                                      .getDeclaredMethods();

        for (XLSXHeader xlsxHeader : xlsxHeaders) {
            Cell cell = row.getCell(xlsxHeader.getColumnIndex());
            String field = xlsxHeader.getFieldName();
            Optional<Method> setter = Arrays.stream(declaredMethods)
                                            .filter(method -> isSetterMethod(field, method))
                                            .findFirst();
            if (setter.isPresent()) {
                Method setMethod = setter.get();
                setMethod.invoke(obj, cell.getStringCellValue());
            }
        }

        return obj;
    }

    private boolean isSetterMethod(String field, Method method) {
        return method.getName()
                     .equals("set" + field.substring(0, 1)
                                          .toUpperCase()
                             + field.substring(1));
    }

    private List<XLSXHeader> modelObjectToXLSXHeader(Class<T> cls, Sheet sheet) {
        return Stream.of(cls.getDeclaredFields())
                     .filter(field -> field.getAnnotation(XLSXField.class) != null)
                     .map(field -> {
                         XLSXField importField = field.getAnnotation(XLSXField.class);
                         String xlsxColumn = importField.column();
                         int columnIndex = findColumnIndex(xlsxColumn, sheet);
                         return new XLSXHeader(field.getName(), xlsxColumn, columnIndex);
                     })
                     .collect(Collectors.toList());
    }

    private int findColumnIndex(String columnTitle, Sheet sheet) {
        Row row = sheet.getRow(HEADER_ROW_INDEX);

        if (row != null) {
            for (Cell cell : row) {
                if (CellType.STRING.equals(cell.getCellTypeEnum()) && columnTitle.equals(cell.getStringCellValue())) {
                    return cell.getColumnIndex();
                }
            }
        }
        return 0;
    }
}
