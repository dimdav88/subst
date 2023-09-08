package com.ue.bor.service;

import java.util.List;
import com.ue.bor.model.Voltage;

public interface VoltageService {
	Voltage addVoltage(Voltage voltage);
	Voltage updateVoltage(Voltage voltage);
	void removeVoltage(Voltage voltage);
	List<Voltage> getAllVoltage();

}
