package caixaverso.agencias.util;

import caixaverso.agencias.dto.AgenciaDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;

public class ExcelExporter {

    public static XSSFWorkbook exportToExcel(List<AgenciaDTO> agenciasDto) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Agências");

        // Cabeçalho
        Row headerRow = sheet.createRow(0);
        String[] headers = {"CGC", "Nome", "Responsável", "cep", "cidade", "estado", "Data Inauguração"};

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Dados
        int rowNum = 1;
        for (AgenciaDTO agenciaDto : agenciasDto) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(agenciaDto.getCgc());
            row.createCell(1).setCellValue(agenciaDto.getNomeAgencia());
            row.createCell(2).setCellValue(agenciaDto.getNomeGestor());
            row.createCell(3).setCellValue(agenciaDto.getCep());
            row.createCell(4).setCellValue(agenciaDto.getCidade() != null ? agenciaDto.getCidade() : "");
            row.createCell(5).setCellValue(agenciaDto.getEstado() != null ? agenciaDto.getEstado() : "");
            row.createCell(6).setCellValue(agenciaDto.getDataInauguracao().toString());
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
    }
}
