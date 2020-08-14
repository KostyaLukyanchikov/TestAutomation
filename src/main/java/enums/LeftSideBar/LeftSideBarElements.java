package enums.LeftSideBar;

public enum LeftSideBarElements {

    LEFT_SIDE_HOME ("Home"),
    LEFT_SIDE_CONTACT_FORM ("Contact Form"),
    LEFT_SIDE_SERVICE ("Service"),
    LEFT_SIDE_METALS_COLORS ("Metals & Colors"),
    LEFT_SIDE_ELEMENTS_PACKS("Element Packs");

    private String leftSideBarElement;

    LeftSideBarElements(String leftSideBarElement) {
        this.leftSideBarElement = leftSideBarElement;
    }

    public String getLeftSideBarElement() {
        return leftSideBarElement;
    }
}
