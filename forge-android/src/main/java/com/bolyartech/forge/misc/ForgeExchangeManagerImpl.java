package com.bolyartech.forge.misc;

import com.bolyartech.forge.app_unit.ResidentComponent;
import com.bolyartech.forge.app_unit.UnitManager;
import com.bolyartech.forge.exchange.Exchange;
import com.bolyartech.forge.exchange.ExchangeOutcome;
import com.bolyartech.forge.exchange.ForgeExchangeFunctionality;
import com.bolyartech.forge.exchange.ForgeExchangeManager;
import com.bolyartech.forge.exchange.ForgeExchangeResult;

import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by ogre on 2015-11-03 10:15
 */
public class ForgeExchangeManagerImpl implements ForgeExchangeManager {
    private final UnitManager mUnitManager;
    private final ForgeExchangeFunctionality mForgeExchangeFunctionality;
    private final AtomicLong mExchangeIdGenerator = new AtomicLong(0);


    public ForgeExchangeManagerImpl(UnitManager mUnitManager, ForgeExchangeFunctionality mForgeExchangeFunctionality) {
        this.mUnitManager = mUnitManager;
        this.mForgeExchangeFunctionality = mForgeExchangeFunctionality;
    }


    @Override
    public long generateXId() {
        return mExchangeIdGenerator.incrementAndGet();
    }


    @Override
    public void executeExchange(Exchange<ForgeExchangeResult> exchange, Long xId) {
        mForgeExchangeFunctionality.executeExchange(exchange, xId);
    }


    @Override
    public void onExchangeCompleted(ExchangeOutcome<ForgeExchangeResult> outcome, long exchangeId) {
        ResidentComponent ac = mUnitManager.getActiveResidentComponent();
        if (ac != null && ac instanceof ForgeExchangeFunctionality.Listener) {
            // suppressed because it if is instanceof ForgeExchangeFunctionality.Listener then the
            // type parameter is ForgeExchangeResult
            @SuppressWarnings("unchecked") ForgeExchangeFunctionality.Listener<ForgeExchangeResult> tmp = (ForgeExchangeFunctionality.Listener) ac;
            tmp.onExchangeCompleted(outcome, exchangeId);
        }
    }
}
