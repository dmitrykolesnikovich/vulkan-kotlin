package tests

import io.kotlintest.specs.StringSpec
import main.isNotGithubAction
import org.lwjgl.vulkan.VK11.VK_API_VERSION_1_1
import vkk._10.structs.ApplicationInfo
import vkk._10.structs.InstanceCreateInfo
import vkk.identifiers.UniqueInstance

class `01 initInstance` : StringSpec() {

    val appName = "01_InitInstance"
    val engineName = "Vulkan.hpp"

    init {

        if (isNotGithubAction)
            "01 initInstance" {

                // initialize the vk::ApplicationInfo structure
                val applicationInfo = ApplicationInfo(appName, 1, engineName, 1, VK_API_VERSION_1_1)

                // initialize the vk::InstanceCreateInfo
                val instanceCreateInfo = InstanceCreateInfo(applicationInfo)

                // create a UniqueInstance
                val instance = UniqueInstance(instanceCreateInfo)

                // Note: No need to explicitly destroy the instance, as the corresponding destroy function is
                // called by the destructor of the UniqueInstance on leaving this scope.
            }
    }
}