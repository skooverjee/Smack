package com.skooverjee.smack

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatarImage = "profiledefault"
    var userAvatarBackgroundColour = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View) {
        val random = Random()
        val colour = random.nextInt(2)
        val avatar = random.nextInt(28)

        userAvatarImage = if (colour == 0) {
            "light$avatar"
        } else {
            "dark$avatar"
        }

        val resourceId = resources.getIdentifier(userAvatarImage, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)
    }

    fun generateBackgroundColourBtnClicked(view: View) {
        val random = Random()
        var r = random.nextInt(255)
        var g = random.nextInt(255)
        var b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r, g, b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        userAvatarBackgroundColour = "[$savedR, $savedG, $savedB, 1]"
    }

    fun createUserBtnClicked(view: View) {

    }

}
