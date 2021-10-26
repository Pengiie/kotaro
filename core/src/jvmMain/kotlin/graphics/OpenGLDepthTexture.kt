package dev.pengie.kotaro.graphics

import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL

class OpenGLDepthTexture : OpenGLTexture() {

    override fun init(data: TexData) {
        id = glGenTextures()
        bind()
        glTexImage2D(GL_TEXTURE_2D, 0, GL_DEPTH_COMPONENT, data.width, data.height, 0, GL_DEPTH_COMPONENT, GL_FLOAT, NULL)
        unbind()
    }
}