package com.techtitudetribe.ncertkitab;

public class ChapterPdfAdapter {

    String name, class_name, sub_pdf, chapter_no, chapter_name;

    public ChapterPdfAdapter(String name, String class_name, String sub_pdf, String chapter_no, String chapter_name) {
        this.name = name;
        this.class_name = class_name;
        this.sub_pdf = sub_pdf;
        this.chapter_no = chapter_no;
        this.chapter_name = chapter_name;
    }

    public ChapterPdfAdapter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getSub_pdf() {
        return sub_pdf;
    }

    public void setSub_pdf(String sub_pdf) {
        this.sub_pdf = sub_pdf;
    }

    public String getChapter_no() {
        return chapter_no;
    }

    public void setChapter_no(String chapter_no) {
        this.chapter_no = chapter_no;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }
}
