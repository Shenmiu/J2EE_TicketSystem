package edu.nju.dto;

import edu.nju.model.VenuePlan;
import edu.nju.util.LocalDateTimeUtil;

/**
 * @author Shenmiu
 * @date 2018/03/19
 * <p>
 * 用于保存场馆计划的简介
 */
public class VenuePlanBriefDTO {

    /**
     * 场馆计划的id
     */
    private Integer venuePlanId;

    /**
     * 场馆计划开始时间，每个计划的开始时间不可以相同
     */
    private String begin;

    /**
     * 场馆计划结束时间，每个计划的结束时间不可以相同
     */
    private String end;

    /**
     * 演出城市
     */
    private String city;

    /**
     * 演出场馆名称
     */
    private String venueName;

    /**
     * 演出类型
     */
    private String showType;

    /**
     * 简单描述
     */
    private String description;

    /**
     * 票价总收入
     */
    private Integer totalIncome;

    /**
     * 实际结算收入
     */
    private Integer actualIncome;

    public VenuePlanBriefDTO(VenuePlan venuePlan) {
        this.venuePlanId = venuePlan.getVenuePlanId();
        this.begin = LocalDateTimeUtil.formatTillMinute(venuePlan.getBegin());
        this.end = LocalDateTimeUtil.formatTillMinute(venuePlan.getEndTime());
        this.city = venuePlan.getVenue().getCity();
        this.venueName = venuePlan.getVenue().getName();
        this.showType = venuePlan.getShowType().getValue();
        this.description = venuePlan.getDescription();

        this.totalIncome = venuePlan.getTotalIncome();
        this.actualIncome = venuePlan.getActualIncome();
    }

    public Integer getVenuePlanId() {
        return venuePlanId;
    }

    public void setVenuePlanId(Integer venuePlanId) {
        this.venuePlanId = venuePlanId;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Integer totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Integer getActualIncome() {
        return actualIncome;
    }

    public void setActualIncome(Integer actualIncome) {
        this.actualIncome = actualIncome;
    }

    @Override
    public String toString() {
        return "VenuePlanBriefDTO{" +
                "venuePlanId=" + venuePlanId +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", city='" + city + '\'' +
                ", venueName='" + venueName + '\'' +
                ", showType='" + showType + '\'' +
                ", description='" + description + '\'' +
                ", totalIncome=" + totalIncome +
                ", actualIncome=" + actualIncome +
                '}';
    }
}
