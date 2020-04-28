package ru.lg.SovietMod.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.commons.io.IOUtils;

import com.google.common.collect.Maps;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.world.gen.structure.template.Template;

public class TemplateSaver
{
    public Map<String, Template> templates = Maps.<String, Template>newHashMap();
   
    public String baseFolder;
    public DataFixer fixer;

    public TemplateSaver(String bF, DataFixer dF)
    {
        this.baseFolder = bF;
        this.fixer = dF;
    }

    public Template getTemplate(@Nullable MinecraftServer server, ResourceLocation id)
    {
        Template template = this.get(server, id);

        if (template == null)
        {
            template = new Template();
            this.templates.put(id.getResourcePath(), template);
        }

        return template;
    }

    @Nullable
    public Template get(@Nullable MinecraftServer server, ResourceLocation templatePath)
    {
        String s = templatePath.getResourcePath();

        if (this.templates.containsKey(s))
        {
            return this.templates.get(s);
        }
        else
        {
            return this.templates.containsKey(s) ? (Template)this.templates.get(s) : null;
        }
    }


    /**
     * writes the template to an external folder
     */
    public boolean writeTemplate(@Nullable MinecraftServer server, ResourceLocation id)
    {
        String s = id.getResourcePath();

        if (server != null && this.templates.containsKey(s))
        {
            File file1 = new File(this.baseFolder);

            if (!file1.exists())
            {
                if (!file1.mkdirs())
                {
                    return false;
                }
            }
            else if (!file1.isDirectory())
            {
                return false;
            }

            File file2 = new File(file1, s + ".nbt");
            Template template = this.templates.get(s);
            OutputStream outputstream = null;
            boolean flag;

            try
            {
                NBTTagCompound nbttagcompound = template.writeToNBT(new NBTTagCompound());
                outputstream = new FileOutputStream(file2);
                CompressedStreamTools.writeCompressed(nbttagcompound, outputstream);
                return true;
            }
            catch (Throwable var13)
            {
                flag = false;
            }
            finally
            {
                IOUtils.closeQuietly(outputstream);
            }

            return flag;
        }
        else
        {
            return false;
        }
    }
}
