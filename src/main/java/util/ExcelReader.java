package util;

public class ExcelReader {
    //code mẫu từ gpt
//    public static void main(String[] args) {
//        String filePath = "data.xlsx";
//
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = WorkbookFactory.create(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(0); // lấy sheet đầu tiên
//
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            System.out.print(cell.getStringCellValue() + "\t");
//                            break;
//                        case NUMERIC:
//                            if (DateUtil.isCellDateFormatted(cell)) {
//                                System.out.print(cell.getDateCellValue() + "\t");
//                            } else {
//                                System.out.print(cell.getNumericCellValue() + "\t");
//                            }
//                            break;
//                        case BOOLEAN:
//                            System.out.print(cell.getBooleanCellValue() + "\t");
//                            break;
//                        case FORMULA:
//                            System.out.print(cell.getCellFormula() + "\t");
//                            break;
//                        case BLANK:
//                            System.out.print("[BLANK]\t");
//                            break;
//                        default:
//                            System.out.print("[UNKNOWN]\t");
//                    }
//                }
//                System.out.println();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
