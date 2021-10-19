package dev.pengie.kotaro.graphics

import org.lwjgl.opengl.GL30.*

class OpenGLRenderLayer(width: Int, height: Int) : RenderLayer(width, height) {

    private var id: Int = -1
    private var texture: OpenGLTexture = OpenGLTexture()

    override fun init() {
        id = glGenFramebuffers()
        bind()
        texture.init(TexData(width = width, height = height))
        glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, texture.id, 0)
        unbind()
    }

    override fun bind() {
        glBindFramebuffer(GL_FRAMEBUFFER, id)
    }

    override fun unbind() {
        glBindFramebuffer(GL_FRAMEBUFFER, 0)
    }

    override fun getTexture(): Texture = texture

    override fun dispose() {
        glDeleteFramebuffers(id)
    }

}

actual object RenderLayerFactory {
    actual operator fun invoke(width: Int, height: Int): RenderLayer = OpenGLRenderLayer(width, height)
}