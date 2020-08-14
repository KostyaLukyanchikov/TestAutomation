package enums;

public enum UIElements {

    //Assertions
    HOME_PAGE ("Home Page"),
    EPAM_JDI_URL ("https://github.com/epam/JDI"),

    //Home Page Images
    IMAGE_TEXT_1 ("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    IMAGE_TEXT_2 ("To be flexible and\n" + "customizable"),
    IMAGE_TEXT_3 ("To be multiplatform"),
    IMAGE_TEXT_4 ("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"),

    //Home Page Body Text
    BODY_TEXT_1 ("EPAM FRAMEWORK WISHES…"),
    BODY_TEXT_2 ("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
                           " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                           " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS" +
                           " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN" +
                           " REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA" +
                           " PARIATUR."),
    BODY_TEXT_3 ("JDI GITHUB");


    private String uIElement;

    UIElements(String uIElement) {
        this.uIElement = uIElement;
    }

    public String getUiElement() {
        return uIElement;
    }

}
