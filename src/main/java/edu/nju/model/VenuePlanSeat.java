package edu.nju.model;

import com.alibaba.fastjson.annotation.JSONType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Shenmiu
 * @date 2018/03/15
 * <p>
 * 表示某个场馆计划座位的使用情况
 */
@Entity
@Table(name = "venue_plan_seat")
@JSONType(ignores = "venuePlan", orders = {"row", "column", "typeChar"})
public class VenuePlanSeat implements Serializable {

    /**
     * 与场馆计划多对一
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "venuePlanId", foreignKey = @ForeignKey(name = "FK_VENUE_PLAN"))
    private VenuePlan venuePlan;

    /**
     * 该座位所在行
     */
    private int row;

    /**
     * 该座位所在列
     */
    @Column(name = "`column`")
    private int column;

    /**
     * 表示该座位类型的字符
     */
    private char typeChar;

    public VenuePlan getVenuePlan() {
        return venuePlan;
    }

    public void setVenuePlan(VenuePlan venuePlan) {
        this.venuePlan = venuePlan;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getTypeChar() {
        return typeChar;
    }

    public void setTypeChar(char typeChar) {
        this.typeChar = typeChar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VenuePlanSeat that = (VenuePlanSeat) o;

        if (row != that.row) {
            return false;
        }
        if (column != that.column) {
            return false;
        }
        if (typeChar != that.typeChar) {
            return false;
        }
        return venuePlan.equals(that.venuePlan);
    }

    @Override
    public int hashCode() {
        int result = venuePlan.hashCode();
        result = 31 * result + row;
        result = 31 * result + column;
        result = 31 * result + (int) typeChar;
        return result;
    }
}