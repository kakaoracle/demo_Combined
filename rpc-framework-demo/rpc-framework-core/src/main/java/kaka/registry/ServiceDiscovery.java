package kaka.registry;

import kaka.extension.SPI;
import kaka.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * 根据请求内容 --> 找到服务ip
 *
 */
@SPI
public interface ServiceDiscovery {
    /**
     * lookup service by rpcServiceName
     *
     * @param rpcRequest rpc service pojo
     * @return service address
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
