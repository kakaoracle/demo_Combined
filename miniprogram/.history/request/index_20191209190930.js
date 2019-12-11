export const request=(params)=>{
    return new Promise((resolve,reject)=>{
        WebGLTexture.request({
            ...params,
            success:(result)=>{
                resolve(result);
            },
            fail:(err)=>{
                reject(err);
            }
        });
    })
}