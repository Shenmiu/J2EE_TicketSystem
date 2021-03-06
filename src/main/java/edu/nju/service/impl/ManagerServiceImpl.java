package edu.nju.service.impl;

import edu.nju.dao.ManagerDao;
import edu.nju.dao.VenuePlanDao;
import edu.nju.model.Manager;
import edu.nju.model.VenuePlan;
import edu.nju.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Shenmiu
 * @date 2018/03/26
 * <p>
 * 经理业务逻辑的实现类
 */
@Service("managerService")
@Transactional(rollbackFor = RuntimeException.class)
public class ManagerServiceImpl implements ManagerService {

    /**
     * 经理id
     */
    private final static int MEMBER_ID = 1;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private VenuePlanDao venuePlanDao;

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public boolean login(Manager manager) {
        Optional<Manager> optionalManager = managerDao.findById(manager.getId());
        //当经理不为空且密码相同时就返回true
        return optionalManager.isPresent() && optionalManager.get().getPassword().equals(manager.getPassword());
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public Manager getManager(int managerId) {
        return managerDao.findById(managerId).get();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean settlePlan(int venuePlanId, int rate) {
        VenuePlan venuePlan = venuePlanDao.findById(venuePlanId).get();
        int totalIncome = venuePlan.getTotalIncome();
        int actualIncome = totalIncome * rate / 10;

        //计划被结算
        venuePlan.setSettle(true);

        //场馆计划实际票价收入
        venuePlan.setActualIncome(actualIncome);

        //从未结算总收入中扣除票价总收入
        Manager manager = managerDao.findById(MEMBER_ID).get();
        manager.setUnsettleIncome(manager.getUnsettleIncome() - totalIncome);
        //系统赚取差价
        manager.setSettleIncome(manager.getSettleIncome() + totalIncome - actualIncome);

        return true;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public Manager getFinance() {
        return managerDao.findById(MEMBER_ID).get();
    }
}
