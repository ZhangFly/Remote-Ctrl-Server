package application.actions.user;

import application.model.AppMsg;
import wtf.apis.WTFSocketAPIsAction;

import wtf.socket.WTFSocket;
import wtf.socket.protocol.WTFSocketMsg;
import wtf.socket.routing.item.WTFSocketRoutingItem;

import java.util.List;

/**
 * 注销功能
 */
public class UnregisterAction_1_0 implements WTFSocketAPIsAction {

    public void doAction(WTFSocketMsg msg, List<WTFSocketMsg> responses) {

        final WTFSocketRoutingItem item = WTFSocket.ROUTING.getFormalMap().getItem(msg.getFrom());
        WTFSocket.ROUTING.getFormalMap().unRegister(item);

        final WTFSocketMsg response = msg.makeResponse();
        response.setBody(new AppMsg().setFlag(1));
        responses.add(response);
    }
}
