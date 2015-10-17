package com.itclass;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;


public class TTM extends JFrame{


    TTM() {
        setSize(640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        List<Record> records = new ArrayList<>();
        records.add(new Record("sdf", "werew"));
        records.add(new Record("qwe23", "5677"));
        records.add(new Record("5465y", "ghjhgj"));
        JTable table = new JTable(new TModel(records));
        DefaultTableModel ff;
        add(table);

    }

    public static void main(String[] args) {
       TTM ttm = new TTM();
        ttm.setVisible(true);

    }
}

class Record {
    private String name;
    private String other;

    public Record(String name, String other) {
        this.name = name;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}

class TModel implements TableModel {

    List<Record> records;

    public TModel(List<Record> records) {
        this.records = records;
    }

    @Override
    public int getRowCount() {
        return records.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex==0)
            return "Name";
        if(columnIndex==1)
            return "Other";
        return "None";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return records.get(rowIndex).getName();
            case 1:
                return records.get(rowIndex).getOther();
            default:
                return null;
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}