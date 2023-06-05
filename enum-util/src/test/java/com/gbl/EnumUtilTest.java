package com.gbl;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.gbl.DeliveryStatusEnum.*;

public class EnumUtilTest {

    @Test
    public void shouldAnswerWithTrue() {
        List<DeliveryStatusEnum> unAllocateCarStatusEnumList = EnumUtil.prevAll(ALLOCATED_CAR);
        List<Integer> unAllocateCarStatusList = unAllocateCarStatusEnumList.stream().map(DeliveryStatusEnum::getState).collect(Collectors.toList());
        System.out.println("unAllocateCarStatusList = " + unAllocateCarStatusList);

        List<DeliveryStatusEnum> unProductDeliveryStatusEnumList = EnumUtil.Between(ALLOCATING, PRODUCTION_CAR_TRANSFERRING);
        List<Integer> unProductDeliveryStatusList = unProductDeliveryStatusEnumList.stream().map(DeliveryStatusEnum::getState).collect(Collectors.toList());
        System.out.println("unProductDeliveryStatusList = " + unProductDeliveryStatusList);

        List<CarStatusEnum> unProductCarStatusEnumList = EnumUtil.prevAll(CarStatusEnum.ASSEMBLER_ONLINE);
        List<Integer> unProductCarStatusList = unProductCarStatusEnumList.stream().map(CarStatusEnum::getState).collect(Collectors.toList());
        System.out.println("unProductCarStatusList = " + unProductCarStatusList);

        List<DeliveryStatusEnum> producingDeliveryStatusEnumList = EnumUtil.Between(ALLOCATING, PRODUCTION_CAR_TRANSFERRING);
        List<Integer> producingDeliveryStatusList = producingDeliveryStatusEnumList.stream().map(DeliveryStatusEnum::getState).collect(Collectors.toList());
        System.out.println("producingDeliveryStatusList = " + producingDeliveryStatusList);

        List<CarStatusEnum> producingCarStatusEnumList = EnumUtil.Between(CarStatusEnum.WAIT_PRODUCTION, CarStatusEnum.PRODUCTION_CAR_TRANSFERRING);
        List<Integer> producingCarStatusList = producingCarStatusEnumList.stream().map(CarStatusEnum::getState).collect(Collectors.toList());
        System.out.println("producingCarStatusList = " + producingCarStatusList);

        List<DeliveryStatusEnum> tmsDeliveryStatusEnumList = EnumUtil.Between(ALLOCATED_CAR, DELIVERY_RECEIVE_CAR);
        List<Integer> tmsDeliveryStatusList = tmsDeliveryStatusEnumList.stream().map(DeliveryStatusEnum::getState).collect(Collectors.toList());
        System.out.println("tmsDeliveryStatusList = " + tmsDeliveryStatusList);

        List<CarStatusEnum> tmsCarStatusEnumList = EnumUtil.Between(CarStatusEnum.CERTIFICATE_COMPLETE, CarStatusEnum.DELIVERY_RECEIVE_CAR);
        List<Integer> tmsCarStatusList = tmsCarStatusEnumList.stream().map(CarStatusEnum::getState).collect(Collectors.toList());
        System.out.println("tmsCarStatusList = " + tmsCarStatusList);

        List<DeliveryStatusEnum> wmsAllocatedDeliveryStatusEnumList = EnumUtil.Between(PRODUCTION_CAR_TRANSFERRING, SCHEDULED);
        List<Integer> wmsAllocatedDeliveryStatusList = wmsAllocatedDeliveryStatusEnumList.stream().map(DeliveryStatusEnum::getState).collect(Collectors.toList());
        System.out.println("wmsAllocatedDeliveryStatusList = " + wmsAllocatedDeliveryStatusList);

        List<CarStatusEnum> wmsAllocatedCarStatusEnumList = EnumUtil.Between(CarStatusEnum.PRODUCTION_CAR_TRANSFERRING, CarStatusEnum.ARRANGE_COMPLETE);
        List<Integer> wmsAllocatedCarStatusList = wmsAllocatedCarStatusEnumList.stream().map(CarStatusEnum::getState).collect(Collectors.toList());
        System.out.println("wmsAllocatedCarStatusList = " + wmsAllocatedCarStatusList);

        List<DeliveryStatusEnum> wmsScheduledDeliveryStatusEnumList = EnumUtil.Between(WAIT_PICK_CAR, ARRANGE_COMPLETE);
        List<Integer> wmsScheduledDeliveryStatusList = wmsScheduledDeliveryStatusEnumList.stream().map(DeliveryStatusEnum::getState).collect(Collectors.toList());
        System.out.println("wmsScheduledDeliveryStatusList = " + wmsScheduledDeliveryStatusList);

        List<CarStatusEnum> wmsScheduledCarStatusEnumList = EnumUtil.Between(CarStatusEnum.DELIVERY_RECEIVE_CAR, CarStatusEnum.ARRANGE_COMPLETE);
        List<Integer> wmsScheduledCarStatusList = wmsScheduledCarStatusEnumList.stream().map(CarStatusEnum::getState).collect(Collectors.toList());
        System.out.println("wmsScheduledCarStatusList = " + wmsScheduledCarStatusList);

        List<DeliveryStatusEnum> wmsArrangeCompleteDeliveryStatusEnumList = EnumUtil.Between(SCHEDULED, CONFIRM_PICK_CAR);
        List<Integer> wmsArrangeCompleteDeliveryStatusList = wmsArrangeCompleteDeliveryStatusEnumList.stream().map(DeliveryStatusEnum::getState).collect(Collectors.toList());
        System.out.println("wmsArrangeCompleteDeliveryStatusList = " + wmsArrangeCompleteDeliveryStatusList);

        List<CarStatusEnum> wmsArrangeCompleteCarStatusEnumList = EnumUtil.Between(CarStatusEnum.PDI_CHECK_PASS, CarStatusEnum.ACTIVATED);
        List<Integer> wmsArrangeCompleteCarStatusList = wmsArrangeCompleteCarStatusEnumList.stream().map(CarStatusEnum::getState).collect(Collectors.toList());
        System.out.println("wmsArrangeCompleteCarStatusList = " + wmsArrangeCompleteCarStatusList);

    }
}
