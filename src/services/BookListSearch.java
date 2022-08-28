package services;

import entities.BookList;
import entities.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class BookListSearch {
    public ObservableList<BookList> getListItems(String keyWord, String subject, Integer year, String author, String language) {
        ObservableList<BookList> list = FXCollections.observableArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
//        System.out.println(queryBuilder(keyWord, subject, year,author, language));
        Query query = em.createQuery(queryBuilder(keyWord, subject, year,author, language));
        List<Books> booksList = query.getResultList();
        for (Books b : booksList) {
            BookList bookList = new BookList();
            if (b.getBookTitle() != null) {
                bookList.setBookTitle(b.getBookTitle());
            }
            if(b.getBookSubject() != null) {
                bookList.setBookSubject(b.getBookSubject().getSubject());
            }
            if(b.getAuthor() != null) {
                bookList.setAuthor(b.getAuthor().getAuthorName());
            }
            bookList.setAuthor2(b.getAuthor2().getAuthorName());
            bookList.setLanguage(b.getLanguage().getLanguage());
            bookList.setLocation(b.getLocation());
            bookList.setYearOfPublish(b.getYearOfPublish());
            list.add(bookList);
        }
        em.close();
        emf.close();


        return list;
    }

    /**
     *
     * @param keyWord
     * @param subject
     * @param year
     * @param author
     * @param language
     */
    public void exportToExcel(String keyWord, String subject, Integer year, String author, String language) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Scale");
            Font font = sheet.getWorkbook().createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 14);
            CellStyle style = sheet.getWorkbook().createCellStyle();
            style.setFont(font);
            style.setWrapText(true);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            XSSFRow header1 = sheet.createRow(0);
            header1.setRowStyle(style);
            header1.createCell(0).setCellValue("ت");
            header1.createCell(1).setCellValue("ناونیشان");
            header1.createCell(2).setCellValue("ناوی نووسەر١ ");
            header1.createCell(3).setCellValue("ناوی نووسەر٢");
            header1.createCell(4).setCellValue("ساڵی دەرچوون");
            header1.createCell(5).setCellValue("بانەت");
            header1.createCell(6).setCellValue("زمان");



            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery(queryBuilder(keyWord, subject, year,author, language));
            List<Books> booksList = query.getResultList();
            int index = 1;
            Integer sequence = 0;

            for (Books b: booksList) {

                XSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(sequence + 1);
                row.createCell(1).setCellValue(b.getBookTitle());
                row.createCell(2).setCellValue(b.getAuthor().getAuthorName());
                row.createCell(3).setCellValue(b.getAuthor2().getAuthorName());
                row.createCell(4).setCellValue(b.getYearOfPublish());
                row.createCell(5).setCellValue(b.getBookSubject().getSubject());
                row.createCell(6).setCellValue(b.getLanguage().getLanguage());


                index += 1;
                sequence ++;
            }


            String fileName = "_راپۆرتی کتێب_" + keyWord+ author+language + LocalDate.now().toString() + ".xlsx";
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:/data", fileName));
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {

        }
        try {
            String fileName = "_راپۆرتی کتێب_" + keyWord+ author+language + LocalDate.now().toString() + ".xlsx";;
            File file = new File("C:/data", fileName);
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()){
                desktop.open(file);
            }

        }
        catch (Exception err){
            err.getLocalizedMessage();

        }
    }




    String queryBuilder(String keyWord, String subject, Integer year, String author, String language){
        String keyWordQ="";
        String subjectQ = "";
        String yearQ = "";
        String authorQ = "";
        String languageQ ="";
        if(!keyWord.isEmpty()){
            if(!subject.isEmpty()  || year != null || !author.isEmpty() || !language.isEmpty()) {
                keyWordQ = "b.bookTitle LIKE  '%" + keyWord + "%' AND";
            }
            else {
                keyWordQ = "b.bookTitle LIKE '%" + keyWord + "%'";
            }
        }
        if(!subject.isEmpty()){
            if( year != null || !author.isEmpty() || !language.isEmpty()) {
                subjectQ = " b.bookSubject.subject = '" + subject + "' AND";
            }
            else {
                subjectQ = " b.bookSubject.subject = '" + subject + "'";
            }
        }
        if(year != null) {
            if( !author.isEmpty() || !language.isEmpty()) {
                yearQ = " b.yearOfPublish = " + year + " AND";
            }
            else {
                yearQ = " b.yearOfPublish = " + year ;
            }
        }
        if(!author.isEmpty()){
            if(!language.isEmpty()) {
                authorQ = " b.author.authorName LIKE  '%" + author + "%' AND";
            }
            else {
                authorQ = " b.author.authorName LIKE  '%" + author + "%'";
            }
        }
        if(!language.isEmpty()){
            languageQ = " b.language.language = '" +language + "'";
        }

        String query = " Select b From Books b where " + keyWordQ +subjectQ + yearQ + authorQ +languageQ;

        return query;
    }
}
