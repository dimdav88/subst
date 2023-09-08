package com.ue.bor.service;

import java.util.List;

import com.ue.bor.model.Pryednannya;
import com.ue.bor.model.Voltage;

public interface PryednannyaService {
	Pryednannya addPryednannya(Pryednannya pryednannya);
	Pryednannya updatePryednannya(Pryednannya pryednannya);
	void remote(Pryednannya pryednannya);
	List<Pryednannya> getAllPryednannya();
	List<Pryednannya> getPryednannyaByVoltage(Voltage voltage);

}
