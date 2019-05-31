package model;

import java.util.ArrayList;

public class MVCFactory {

    private ArrayList<Whatsit> whatsitList;
    private ArrayList<Widget> widgetsList;
    private int widgetResourceCount;
    private int whatsitResourceCount;

    public MVCFactory(){

        whatsitList = new ArrayList<>();
        widgetsList = new ArrayList<>();

        widgetResourceCount = 30;
        whatsitResourceCount = 10;
    }

    public ArrayList<Whatsit> getWhatsitList() {
        return whatsitList;
    }

    public void setWhatsitList(ArrayList<Whatsit> whatsitList) {
        this.whatsitList = whatsitList;
    }

    public ArrayList<Widget> getWidgetsList() {
        return widgetsList;
    }

    public void setWidgetsList(ArrayList<Widget> widgetsList) {
        this.widgetsList = widgetsList;
    }

    public int getWidgetResourceCount() {
        return widgetResourceCount;
    }

    public void setWidgetResourceCount(int widgetResourceCount) {
        this.widgetResourceCount = widgetResourceCount;
    }

    public int getWhatsitResourceCount() {
        return whatsitResourceCount;
    }

    public void setWhatsitResourceCount(int whatsitResourceCount) {
        this.whatsitResourceCount = whatsitResourceCount;
    }

    public boolean makeWidget(double weight, String description){

        boolean canMakeWidget = false;
        if(widgetResourceCount > 0){

            Widget currentWidget = new Widget(weight, description);
            widgetResourceCount--;
            widgetsList.add(currentWidget);
            canMakeWidget = true;
        }

        return canMakeWidget;

    }

    public boolean makeWhatsit(int size, String name){

        boolean canMakeWhatsit = false;

        if(whatsitResourceCount > 5){

            Whatsit currentWhatsit = new Whatsit(size, name);
            whatsitResourceCount -= 5;
            whatsitList.add(currentWhatsit);
            canMakeWhatsit = true;
        }

        return canMakeWhatsit;
    }

}
