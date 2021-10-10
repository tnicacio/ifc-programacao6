package com.tnicacio.residentialremotecontroller;

import com.tnicacio.residentialremotecontroller.ceillingfan.handler.CeillingFanHighCommand;
import com.tnicacio.residentialremotecontroller.ceillingfan.handler.CeillingFanOffCommand;
import com.tnicacio.residentialremotecontroller.ceillingfan.model.CeillingFan;
import com.tnicacio.residentialremotecontroller.ceillingfan.service.CeillingFanService;
import com.tnicacio.residentialremotecontroller.garagedoor.handler.GarageDownCommand;
import com.tnicacio.residentialremotecontroller.garagedoor.handler.GarageUpCommand;
import com.tnicacio.residentialremotecontroller.garagedoor.model.GarageDoor;
import com.tnicacio.residentialremotecontroller.garagedoor.service.GarageDoorService;
import com.tnicacio.residentialremotecontroller.light.handler.LightOffCommand;
import com.tnicacio.residentialremotecontroller.light.handler.LightOnCommand;
import com.tnicacio.residentialremotecontroller.light.model.Light;
import com.tnicacio.residentialremotecontroller.light.service.LightService;
import com.tnicacio.residentialremotecontroller.remotecontrol.RemoteControl;
import com.tnicacio.residentialremotecontroller.stereo.handler.StereoOffCommand;
import com.tnicacio.residentialremotecontroller.stereo.handler.StereoOnWithCDCommand;
import com.tnicacio.residentialremotecontroller.stereo.model.Stereo;
import com.tnicacio.residentialremotecontroller.stereo.service.StereoService;

public class RemoteLoader {

    public static void main(String... args) {

        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living room");
        LightService livingRoomLightService = new LightService(livingRoomLight);

        GarageDoor houseGarage = new GarageDoor("Main house");
        GarageDoorService garageDoorService = new GarageDoorService(houseGarage);

        Stereo stereo = new Stereo("Living room");
        StereoService stereoService = new StereoService(stereo);

        CeillingFan ceillingFan = new CeillingFan("Living room");
        CeillingFanService ceillingFanService = new CeillingFanService(ceillingFan);

        remoteControl.setCommand(0, new LightOnCommand(livingRoomLightService), new LightOffCommand(livingRoomLightService));
        remoteControl.setCommand(1, new GarageUpCommand(garageDoorService), new GarageDownCommand(garageDoorService));
        remoteControl.setCommand(2, new StereoOnWithCDCommand(stereoService), new StereoOffCommand(stereoService));
        remoteControl.setCommand(3, new CeillingFanHighCommand(ceillingFanService), new CeillingFanOffCommand(ceillingFanService));

        System.out.println(remoteControl.toString());

        remoteControl.onButtonPushed(0);
        remoteControl.offButtonPushed(0);
        remoteControl.onButtonPushed(1);
        remoteControl.offButtonPushed(1);
        remoteControl.onButtonPushed(2);
        remoteControl.offButtonPushed(2);
        remoteControl.onButtonPushed(3);
        remoteControl.offButtonPushed(3);

        remoteControl.onButtonPushed(0);
        remoteControl.onButtonPushed(1);

        remoteControl.undoButtonPushed();
        remoteControl.undoButtonPushed();
        remoteControl.undoButtonPushed();
        remoteControl.undoButtonPushed();

    }

}
