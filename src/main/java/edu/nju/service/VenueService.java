package edu.nju.service;

import edu.nju.dto.*;
import edu.nju.model.Venue;
import edu.nju.model.VenuePlan;

import java.util.List;

/**
 * @author Shenmiu
 * @date 2018/03/15
 * <p>
 * 场馆业务逻辑接口
 */
public interface VenueService {

    //场馆

    /**
     * 查询场馆
     *
     * @param venueId 场馆编号
     * @return 场馆信息
     */
    Venue getVenue(int venueId);

    /**
     * 查询场馆，带上座位信息
     *
     * @param venueId 场馆编号
     * @return 带有座位信息的场馆
     */
    Venue getVenueWithSeatMap(int venueId);

    /**
     * 场馆注册
     *
     * @param venue 场馆信息
     * @return 场馆编号
     */
    int register(Venue venue);

    /**
     * 更新场馆信息
     *
     * @param venue 场馆信息
     * @return 更新场馆信息是否成功
     */
    boolean updateVenue(Venue venue);

    /**
     * 场馆登录
     *
     * @param venue@return 是否登录成功
     */
    boolean login(Venue venue);

    /**
     * 场馆检票登记
     *
     * @param venuePlanSeat 场馆计划座位
     * @return 检票登记是否成功
     */
    boolean seatCheckIn(SeatCheckInDTO venuePlanSeat);

    /**
     * 获取所有正在审批的场馆
     *
     * @return 正在审批的场馆
     */
    List<Venue> getAuditingVenues();

    /**
     * 场馆审批通过
     *
     * @param venueId 场馆编号
     * @return 审批是否成功
     */
    boolean auditPass(int venueId);

    /**
     * 检查场馆是否可以修改信息
     *
     * @param venueId 场馆编号
     * @return 场馆是否可以修改信息
     */
    boolean modifyCheck(int venueId);

    /**
     * 检查有没有距离演出开始不足两周的演出计划，并给未配票订单配票
     */
    void sendTickets();

    /**
     * 获取场馆统计信息
     *
     * @param venueId 场馆编号
     * @return 场馆统计信息
     */
    VenueFinanceDTO getFinance(int venueId);

    /**
     * 获取各场馆统计信息
     *
     * @return 各场馆统计信息列表
     */
    List<VenueStatisticsDTO> getVenueStatistics();

    //场馆计划

    /**
     * 添加一个场馆计划到指定编号的场馆里
     *
     * @param venueId   场馆编号
     * @param venuePlan 新场馆计划
     * @return 添加是否成功
     */
    boolean addVenuePlan(int venueId, VenuePlan venuePlan);

    /**
     * 根据场馆计划id获取演出的具体信息
     * 包括行数，列数，以及座位排布
     *
     * @param venuePlanId 场馆计划id
     * @return 演出具体信息
     */
    VenuePlanDetailDTO getVenuePlanDetail(int venuePlanId);

    /**
     * 获取当前时间往后的最近几场场馆计划简要信息
     *
     * @return 场馆计划传输对象
     */
    List<VenuePlanBriefDTO> getComingVenueBriefPlan();

    /**
     * 获取还未开始的场馆计划信息
     *
     * @param venueId 场馆id
     * @return 还未开始的场馆计划信息列表
     */
    List<VenuePlanBriefDTO> getComingVenuePlans(int venueId);

    /**
     * 获取已经结算的场馆计划信息
     *
     * @param venueId 场馆id
     * @return 已经结算的场馆计划信息列表
     */
    List<VenuePlanBriefDTO> getSettlePlans(int venueId);

    /**
     * 获取未结算的场馆计划信息
     *
     * @param venueId 场馆id
     * @return 未结算的场馆计划信息列表
     */
    List<VenuePlanBriefDTO> getUnsettlePlans(int venueId);

    /**
     * 检查已经结束的场馆计划，并将已预订订单置为已消费订单
     */
    void checkCompleteVenuePlans();

    /**
     * 获取所有已结束但是未结算的场馆计划
     *
     * @return 已结束、为结算的场馆计划列表
     */
    List<VenueAndPlanDTO> getUnsettleVenuePlans();
}
