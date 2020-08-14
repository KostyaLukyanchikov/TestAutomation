package enums;

public enum UIElements {

    //Assertions
    HOME_PAGE ("Home Page"),
    EPAM_JDI_URL ("https://github.com/epam/JDI"),

    //Header Elements
    HEADER_HOME("HOME"),
    HEADER_CONTACT_FORM("CONTACT FORM"),
    HEADER_SERVICE("SERVICE"),
    HEADER_METALS_COLORS("METALS & COLORS"),

    //Left SideBar Elements
    LEFT_SIDE_HOME ("Home"),
    LEFT_SIDE_CONTACT_FORM ("Contact Form"),
    LEFT_SIDE_SERVICE ("Service"),
    LEFT_SIDE_METALS_COLORS ("Metals & Colors"),
    LEFT_SIDE_ELEMENTS_PACKS("Element Packs"),

    //Home Page Images
    IMAGE_TEXT_1 ("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    IMAGE_TEXT_2 ("To be flexible and\n" + "customizable"),
    IMAGE_TEXT_3 ("To be multiplatform"),
    IMAGE_TEXT_4 ("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"),

    //Home Page Body Text
    HEADER_TEXT_1 ("EPAM FRAMEWORK WISHES…"),
    HEADER_TEXT_2 ("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
                           " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                           " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS" +
                           " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN" +
                           " REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA" +
                           " PARIATUR."),
    HEADER_TEXT_3 ("JDI GITHUB");


    private String UIelement;

    UIElements(String UIelement) {
        this.UIelement = UIelement;
    }

    public String getUIelement() {
        return UIelement;
    }

}
