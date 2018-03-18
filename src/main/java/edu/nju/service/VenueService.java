package edu.nju.service;

import edu.nju.dto.VenueBasicInfoDTO;
import edu.nju.dto.VenueSeatInfoDTO;
import edu.nju.model.Venue;
import edu.nju.model.VenuePlan;

/**
 * @author Shenmiu
 * @date 2018/03/15
 * <p>
 * 场馆业务逻辑接口
 */
public interface VenueService {

    /**
     * 查询场馆
     *
     * @param venueId 场馆编号
     * @return 场馆信息
     */
    Venue getVenue(int venueId);

    /**
     * 场馆注册
     *
     * @param venue 场馆信息
     * @return 是否注册成功
     */
    boolean register(Venue venue);

    /**
     * 场馆登录
     *
     * @param venueId       场馆编号
     * @param venuePassword 场馆密码
     * @return 是否登录成功
     */
    boolean login(int venueId, String venuePassword);

    /**
     * 更新场馆基本信息
     *
     * @param venueBasicInfo 场馆信息
     * @return 是否修改成功
     */
    boolean updateBasicInfo(VenueBasicInfoDTO venueBasicInfo);

    /**
     * 更新场馆座位信息
     *
     * @param venueSeatInfo 场馆座位信息
     * @return 更新行数
     */
    boolean updateSeatMap(VenueSeatInfoDTO venueSeatInfo);

    /**
     * 添加一个场馆计划到指定编号的场馆里
     *
     * @param venueId   场馆编号
     * @param venuePlan 新场馆计划
     * @return 添加是否成功
     */
    boolean addVenuePlan(int venueId, VenuePlan venuePlan);
}